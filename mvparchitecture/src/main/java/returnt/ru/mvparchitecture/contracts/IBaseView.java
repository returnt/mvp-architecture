/**
 * File IBaseView
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.contracts
 * Created by 07.11.2017
 */

package returnt.ru.mvparchitecture.contracts;

/**
 * Class IBaseView
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.contracts
 * Created by 07.11.2017
 */
public interface IBaseView {

    default void showProgressDialog() {
    }

    default void hideProgressDialog() {
    }
}
