package per.dg.test.fragment

import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.stx.xhb.xbanner.XBanner
import per.dg.test.R
import per.dg.test.base.fragment.BaseFragment
import per.dg.test.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>() {

//    private lateinit var mBanner : XBanner

    var b = 0

    override fun getInflater(): Int {
        return R.layout.home_fragment
    }

    override fun initView(view: View?) {

    }

    override fun bindData() {
        mBinding.viewmodel = mViewModel
        mBinding.lifecycleOwner = this
        mViewModel.getBanner()
        mViewModel.banners.observe(this, Observer {
//            binding.tv.setText(it.get(0).imagePath)
            mBinding.banner1.setData(it, null)
            mBinding.banner1.setmAdapter(object : XBanner.XBannerAdapter {
                override fun loadBanner(
                    banner: XBanner?,
                    model: Any?,
                    view: View?,
                    position: Int
                ) {
                    Glide.with(mContext).load(it.get(position).imagePath).into(view as ImageView?)
                }
            })
        })
//        mViewModel.a.observe(this, Observer{
//            Log.e("bindData: ", it)
//            mBinding.et2?.setText(it)
//        })
        mBinding.bt?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                mViewModel.a.value = b++.toString()
            }
        })

    }

}