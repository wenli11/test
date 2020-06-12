package per.dg.test.base.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflater())

        mContext = this

        initView()

        initData()

        setDataToView()
    }

    protected abstract fun getInflater(): Int

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract fun setDataToView()

}