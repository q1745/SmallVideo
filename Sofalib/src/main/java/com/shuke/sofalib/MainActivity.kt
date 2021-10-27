package com.shuke.sofalib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.shuke.sofalib.adapter.SofaViewPagerAdapter
import com.shuke.sofalib.fragment.TestFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
    }

    /**
     * 初始化ViewPager
     */
    private fun initViewPager() {
        var titles:MutableList<String> = mutableListOf("图片","视频","文本")
        var fragments:MutableList<Fragment> = mutableListOf(
            TestFragment(),
            TestFragment(),
            TestFragment()
        )

        var adapter:SofaViewPagerAdapter = SofaViewPagerAdapter(titles,
        fragments,supportFragmentManager,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

        sofa_viewpager.adapter = adapter
        sofa_tablayout.setupWithViewPager(sofa_viewpager)
    }


}