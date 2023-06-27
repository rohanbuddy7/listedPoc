package com.rohan.listedpoc.ui.links

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.LineData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.rohan.listedpoc.R
import com.rohan.listedpoc.data.response.DashboardResponse
import com.rohan.listedpoc.data.response.Links
import com.rohan.listedpoc.databinding.FragmentLinksBinding
import com.rohan.listedpoc.utils.ChartHelper
import com.rohan.listedpoc.utils.CommonUtils.getWish
import com.rohan.listedpoc.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LinksFragment : Fragment() {

    private var adapter: LinksAdapter? = null
    private var binding: FragmentLinksBinding? = null
    private val viewmodel by viewModels<LinksViewModel>()
    private var dashboardResponse: DashboardResponse? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLinksBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apicall()
        setup()
        observers()
    }

    private fun apicall() {
        viewmodel.getDashboard()
    }

    private fun setup() {

        binding?.tablayout.let {
            it?.addTab(it.newTab().setCustomView(createCustomTabView(resources.getString(R.string.topLinks), true)));
            it?.addTab(it.newTab().setCustomView(createCustomTabView(resources.getString(R.string.recentLinks), false)));
        }
        val tabSelectedListener: OnTabSelectedListener = object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                upadteFontWhileSwitching(tab, tab.isSelected)
                val position = tab.position
                when(position){
                    0->{
                        if(dashboardResponse!=null){
                            updateList(dashboardResponse!!.data?.topLinks)
                        }
                    }
                    1->{
                        if(dashboardResponse!=null){
                            updateList(dashboardResponse!!.data?.recentLinks)
                        }
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                upadteFontWhileSwitching(tab, tab.isSelected)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        }
        adjustTabsWidth()
        binding?.tablayout?.addOnTabSelectedListener(tabSelectedListener)
        binding?.tablayout?.getTabAt(0)?.select()
        adapter = LinksAdapter(requireContext())
        binding?.recyclerLinks?.adapter = adapter
        binding?.textWish?.text = getWish()


    }

    private fun observers() {

        lifecycleScope.launch {
            viewmodel.dashboardRes.collect(){
                when(it){
                    is NetworkResult.Success->{
                        inflateData(it.data!!)
                    }
                    is NetworkResult.Error->{}
                    is NetworkResult.Loading->{}
                }
            }
        }
    }

    private fun inflateData(dashboardResponse: DashboardResponse) {
        binding?.statusTodaysclick?.let {
             it.imageStatus.let {
                 Glide.with(requireContext()).load(R.drawable.ic_clicks).into(it)
             }
            it.textData.text = dashboardResponse.todayClicks.toString()
            it.textTitle.text = resources.getString(R.string.todayClicks)
        }
        binding?.statusToplocation?.let {
            it.imageStatus.let {
                Glide.with(requireContext()).load(R.drawable.ic_location).into(it)
            }
            it.textData.text = dashboardResponse.topLocation.toString()
            it.textTitle.text = resources.getString(R.string.topLocation)
        }
        binding?.statusTopsource?.let {
            it.imageStatus.let {
                Glide.with(requireContext()).load(R.drawable.ic_source).into(it)
            }
            it.textData.text = dashboardResponse.topSource.toString()
            it.textTitle.text = resources.getString(R.string.topSource)
        }

        dashboardResponse.data?.topLinks?.let{ links ->
            adapter?.addData(links = links);
        }?: kotlin.run {
            print("top link is null")
        }

        updateList(dashboardResponse.data?.topLinks)
        initChart()
        this.dashboardResponse = dashboardResponse;

    }

    private fun initChart() {
        val data = LineData(ChartHelper.setLineChartData(requireContext(), resources))
        binding?.chart?.data = data
        binding?.chart?.setBackgroundColor(resources.getColor(R.color.white))
        binding?.chart?.animateXY(2000, 2000, Easing.EaseInCubic)
        binding?.chart?.axisRight?.isEnabled = false;
        binding?.chart?.xAxis?.position = XAxis.XAxisPosition.BOTTOM
        binding?.chart?.xAxis?.axisLineColor = resources.getColor(R.color.col_F5F5F5)
        binding?.chart?.axisLeft?.axisLineColor = resources.getColor(R.color.col_F5F5F5)
        binding?.chart?.xAxis?.textColor = resources.getColor(R.color.col_999CA0)
        binding?.chart?.axisLeft?.textColor = resources.getColor(R.color.col_999CA0)
        binding?.chart?.setGridBackgroundColor(resources.getColor(R.color.col_F5F5F5))
        binding?.chart?.invalidate();
    }

    fun updateList(links: List<Links?>?){
        links?.let{
            adapter?.addData(links = it);
        }?: kotlin.run {
            print("link is null")
        }
    }

    private fun createCustomTabView(tabText: String, active: Boolean): View {
        val tabCustomView: View = layoutInflater.inflate(R.layout.tab_customview, null)
        val tv: TextView = tabCustomView.findViewById(R.id.tab_textview)
        val root: CardView = tabCustomView.findViewById(R.id.tab_root)
        tv.text = tabText
        updateViews(active, root, tv)
        return tabCustomView
    }

    private fun upadteFontWhileSwitching(tab: TabLayout.Tab, active: Boolean){
        val tabCustomView: View? = tab.getCustomView()
        val tv: TextView? = tabCustomView?.findViewById(R.id.tab_textview)
        val root: CardView? = tabCustomView?.findViewById(R.id.tab_root)
        updateViews(active, root, tv)
    }

    private fun updateViews(active: Boolean, root: CardView?, tv: TextView?){
        if(active) {
            root?.setCardBackgroundColor(resources.getColor(R.color.col_0E6FFF))
            tv?.setTextColor(resources.getColor(R.color.white))
        } else {
            root?.setCardBackgroundColor(resources.getColor(R.color.col_F5F5F5))
            tv?.setTextColor(resources.getColor(R.color.col_999CA0))
        }
    }

    fun adjustTabsWidth(){
        val layout0 = (binding?.tablayout?.getChildAt(0) as LinearLayout).getChildAt(0) as LinearLayout
        val layout1 = (binding?.tablayout?.getChildAt(0) as LinearLayout).getChildAt(1) as LinearLayout
        val layoutParams0 = layout0.layoutParams as LinearLayout.LayoutParams
        val layoutParams1 = layout1.layoutParams as LinearLayout.LayoutParams
        layoutParams0.weight = 0f
        layoutParams1.weight = 0f
        layoutParams0.width = LinearLayout.LayoutParams.WRAP_CONTENT
        layoutParams1.width = LinearLayout.LayoutParams.WRAP_CONTENT
        layout0.layoutParams = layoutParams0
        layout1.layoutParams = layoutParams1
    }

}