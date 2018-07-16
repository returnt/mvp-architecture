/**
 * File BasePresenter
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.contracts
 * Created by 07.11.2017
 */

package returnt.ru.mvparchitecture.presentesr;

import android.util.Log;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import returnt.ru.mvparchitecture.contracts.IBasePresenter;
import returnt.ru.mvparchitecture.contracts.IBaseView;

/**
 * Class BasePresenter
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.contracts
 * Created by 07.11.2017
 */
public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    private static final String TAG = "BasePresenter";

    private static final String ON_ERROR = "onError";

    protected T mView;

    /**
     * Disposable observers container
     */
    private CompositeDisposable mCompositeDisposable;

    /**
     * {@inheritDoc}
     */
    @Override
    public void connectView(T view) {
        mView = view;
        start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disconnectView() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
        mView = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isViewConnected() {
        return mView != null;
    }

    /**
     * Creates new compositeDisposable if needed, adds subscriber to it
     *
     * @param subscriber
     */
    @Override
    public void addToCompositeDisposable(Disposable subscriber) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscriber);
    }

    @Override
    public <D extends Disposable> D addToCompositeDisposableAadGet(D subscriber) {
        addToCompositeDisposable(subscriber);
        return subscriber;
    }

    @Override
    public void logOnError(Throwable e) {
        Log.e(TAG, ON_ERROR, e);
    }
}