package com.shuke.sofalib.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class SofaViewPagerAdapter(
    var titles:MutableList<String>,
    var fragments:MutableList<Fragment>,
    var fm : FragmentManager,
    var behavior:Int) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }
}