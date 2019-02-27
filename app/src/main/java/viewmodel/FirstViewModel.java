package viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.ObservableField;

/**
 * @ProjectName: ReadSource
 * @Package: viewmodel
 * @ClassName: FirstViewModel
 * @Description: java类作用描述
 * @Author: wangc
 * @CreateDate: 2019/2/27 15:21
 * @Version: 1.0
 */
public class FirstViewModel extends ViewModel {

    public final ObservableField<String> lastname = new ObservableField<>();

    public ObservableField<String> setName(){
        lastname.set("李四");
        return lastname;
    }

}
