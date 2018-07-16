/**
 * File ILoadingBasePresenter
 *
 * Author d.a.ganzha
 * Project MVPArchitecture
 * Created by 16.07.18 17:08
 */

package returnt.ru.mvparchitecture.contracts;

/**
 * Class ILoadingBasePresenter
 *
 * Author d.a.ganzha
 * Package returnt.ru.mvparchitecture.contracts
 * Created by 16.07.18 17:08
 */
public interface ILoadingBasePresenter<T extends IBaseView> extends IBasePresenter<T> {

    void showProgressDialog();

    void hideProgressDialog();
}
