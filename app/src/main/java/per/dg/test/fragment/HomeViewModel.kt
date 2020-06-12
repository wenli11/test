package per.dg.test.fragment

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import per.dg.test.utils.httputil.Api
import per.dg.test.utils.httputil.MyCallback
import per.dg.test.utils.httputil.model.Banner

class HomeViewModel : ViewModel() {

    var banners : MutableLiveData<List<Banner>> = MutableLiveData();
//    var name : MutableLiveData<String> = MutableLiveData("dddddddd")
    var _name = MutableLiveData("bbb")
    var name = MutableLiveData("888")
    @get:Bindable
    var a = MutableLiveData("666")
    val b = a
    fun getBanner(){
        Api.getInstance().getHomeBanner(object : MyCallback<List<Banner>>() {
            override fun onFail(errCode: Int, errMsg: String?) {

            }

            override fun onSuccess(t: List<Banner>?) {
                banners.value = t
                name = _name
            }
        })
    }
    
}