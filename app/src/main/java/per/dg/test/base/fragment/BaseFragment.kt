package per.dg.test.base.fragment

import android.content.Context
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.viewbinding.ViewBinding
import per.dg.test.fragment.HomeViewModel
import per.dg.test.utils.httputil.model.Banner
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding> : Fragment() {

    lateinit var mContext : Context
    lateinit var mViewModel : VM
    lateinit var mBinding : VB
    lateinit var viewRoom : View

    var type : ParameterizedType = javaClass.genericSuperclass as ParameterizedType
    var actualTypeArguments = type.actualTypeArguments

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = activity!!

        var clazz : Class<VM> = actualTypeArguments[0] as Class<VM>
        this.mViewModel = ViewModelProviders.of(this).get(clazz)

        bindData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val clazz = type.actualTypeArguments[1] as Class<VB>
        val method = clazz.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        mBinding = method.invoke(null, inflater, container, false) as VB

        viewRoom = mBinding.root
        initView(viewRoom)

        return viewRoom
    }

    abstract fun getInflater() : Int

    abstract fun initView(view: View?)

    abstract fun bindData()

}