package com.example.zz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.launcher.ARouter


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var vp: ViewPager
    lateinit var main_rg: RadioGroup
    lateinit var rb_release: ImageView
    lateinit var rb_index: RadioButton
    lateinit var rb_sofa: RadioButton
    lateinit var rb_find: RadioButton
    lateinit var rb_mine: RadioButton

    var fragments: MutableList<Fragment> = mutableListOf()
    lateinit var viewPager: MainViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        //绘制布局前切换布局样式
        setTheme(R.style.Theme_SmallVideo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView();

        //Log工具
        //Logger.Build().setLog("志强是沙雕").setTag("志强沙雕").build().d()

        //默认选中首页
        setDrawable(R.mipmap.index_true,rb_index)
        rb_index.setTextColor(Color.parseColor("#DF000000"))

        fragments.add(TestFragment())
        viewPager = MainViewPager(supportFragmentManager,fragments,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        vp.adapter = viewPager

        //为RadioButton设置图片
        initData();



        ARouter.getInstance().build("/a/a").navigation()

    }

    fun setDrawable(draw: Int, id: RadioButton) {
        var index = resources.getDrawable(draw)
        //设置图片大小
        index.bounds.set(0,0,60,60)
        id.setCompoundDrawables(null,index,null,null)
    }

    private fun initData() {
        setDrawable(R.mipmap.sofa_false,rb_sofa);

        setDrawable(R.mipmap.find_false,rb_find);

        setDrawable(R.mipmap.mine_false,rb_mine);
    }

    private fun initView() {
        vp = findViewById(R.id.main_vp)
        main_rg = findViewById(R.id.main_rg)
        rb_release = findViewById(R.id.rb_release)
        rb_index = findViewById(R.id.rb_index)
        rb_sofa = findViewById(R.id.rb_sofa)
        rb_find = findViewById(R.id.rb_find)
        rb_mine = findViewById(R.id.rb_mine)

        main_rg.setOnClickListener(this)
        rb_release.setOnClickListener(this)
        rb_index.setOnClickListener(this)
        rb_sofa.setOnClickListener(this)
        rb_find.setOnClickListener(this)
        rb_mine.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.rb_index -> {
                setDrawable(R.mipmap.index_true,rb_index)
                setDrawable(R.mipmap.sofa_false,rb_sofa)
                setDrawable(R.mipmap.find_false,rb_find)
                setDrawable(R.mipmap.mine_false,rb_mine)
                rb_index.setTextColor(Color.parseColor("#DF000000"))
                rb_sofa.setTextColor(Color.parseColor("#97000000"))
                rb_find.setTextColor(Color.parseColor("#97000000"))
                rb_mine.setTextColor(Color.parseColor("#97000000"))
                vp.currentItem = 0
            }
            R.id.rb_sofa -> {
                setDrawable(R.mipmap.index_false,rb_index)
                setDrawable(R.mipmap.sofa_true,rb_sofa)
                setDrawable(R.mipmap.find_false,rb_find)
                setDrawable(R.mipmap.mine_false,rb_mine)
                rb_index.setTextColor(Color.parseColor("#97000000"))
                rb_sofa.setTextColor(Color.parseColor("#DF000000"))
                rb_find.setTextColor(Color.parseColor("#97000000"))
                rb_mine.setTextColor(Color.parseColor("#97000000"))
                vp.currentItem = 0
            }
            R.id.rb_find -> {
                setDrawable(R.mipmap.index_false,rb_index)
                setDrawable(R.mipmap.sofa_false,rb_sofa)
                setDrawable(R.mipmap.find_true,rb_find)
                setDrawable(R.mipmap.mine_false,rb_mine)
                rb_index.setTextColor(Color.parseColor("#97000000"))
                rb_sofa.setTextColor(Color.parseColor("#97000000"))
                rb_find.setTextColor(Color.parseColor("#DF000000"))
                rb_mine.setTextColor(Color.parseColor("#97000000"))
                vp.currentItem = 0
            }
            R.id.rb_mine -> {
                setDrawable(R.mipmap.index_false,rb_index)
                setDrawable(R.mipmap.sofa_false,rb_sofa)
                setDrawable(R.mipmap.find_false,rb_find)
                setDrawable(R.mipmap.mine_true,rb_mine)
                rb_index.setTextColor(Color.parseColor("#97000000"))
                rb_sofa.setTextColor(Color.parseColor("#97000000"))
                rb_find.setTextColor(Color.parseColor("#97000000"))
                rb_mine.setTextColor(Color.parseColor("#DF000000"))
                vp.currentItem = 0
            }
            R.id.rb_release -> Toast.makeText(this, "稍等加上", Toast.LENGTH_SHORT).show()
        }
    }
}