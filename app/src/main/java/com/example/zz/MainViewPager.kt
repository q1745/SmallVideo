package com.example.zz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * @ClassName MainViewPager
 * @Description TODO
 * @Author Zhi Qiang
 * @Email 1745984453@qq.com
 * @Date 2021/10/14 18:15
 * @Version 1.0
 * @ClassDescription
 */
class MainViewPager(var fm: FragmentManager, var list: MutableList<Fragment>, var behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }


}