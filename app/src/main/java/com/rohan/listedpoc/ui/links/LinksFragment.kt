package com.rohan.listedpoc.ui.links

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.rohan.listedpoc.R
import com.rohan.listedpoc.databinding.FragmentLinksBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LinksFragment : Fragment() {

    private var binding: FragmentLinksBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLinksBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()


    }

    private fun setup() {

        binding?.tablayout.let {
            it?.addTab(it.newTab().setCustomView(createCustomTabView(resources.getString(R.string.topLinks), true)));
            it?.addTab(it.newTab().setCustomView(createCustomTabView(resources.getString(R.string.recentLinks), false)));
        }

        val tabSelectedListener: OnTabSelectedListener = object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                upadteFontWhileSwitching(tab, tab.isSelected)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                upadteFontWhileSwitching(tab, tab.isSelected)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        }

        binding?.tablayout?.addOnTabSelectedListener(tabSelectedListener)
        binding?.tablayout?.getTabAt(0)?.select()

        binding?.recyclerLinks?.adapter = LinksAdapter(requireContext())

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

}