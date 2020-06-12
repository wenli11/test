package per.dg.test.activity

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import per.dg.test.R
import per.dg.test.base.activity.BaseActivity
import per.dg.test.adapter.MainFragmentAdapter
import per.dg.test.fragment.HomeFragment

class MainActivity : BaseActivity() {

    private lateinit var mVpMain : ViewPager

    private lateinit var list : MutableList<Fragment>

    override fun getInflater(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mVpMain = findViewById(R.id.vp_main)
    }

    override fun initData() {

        list = mutableListOf()
        list.add(HomeFragment())
    }

    override fun setDataToView() {
        mVpMain.adapter = MainFragmentAdapter(supportFragmentManager, list)
    }
}