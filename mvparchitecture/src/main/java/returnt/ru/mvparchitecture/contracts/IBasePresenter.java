/**
 * File IBasePresenter
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.contracts
 * Created by 07.11.2017
 */

package returnt.ru.mvparchitecture.contracts;

import io.reactivex.disposables.Disposable;
import returnt.ru.mvparchitecture.callback.CallbackApply;

/**
 * Class IBasePresenter
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.contracts
 * Created by 07.11.2017
 */
public interface IBasePresenter<T extends IBaseView> {

    /**
     * Connects view to presenter
     *
     * @param view to connect
     */
    void connectView(T view);

    /**
     * Disconnects view from presenter
     */
    void disconnectView();

    /**
     * Checks if view is connected
     *
     * @return true if view is connected
     */
    boolean isViewConnected();

    /**
     * Starts the job
     */
    void start();

    void addToCompositeDisposable(Disposable subscriber);

    <D extends Disposable> D addToCompositeDisposableAadGet(D subscriber);

    void logOnError(Throwable e);

    void sendToView(CallbackApply<T> callbackApply);

}
