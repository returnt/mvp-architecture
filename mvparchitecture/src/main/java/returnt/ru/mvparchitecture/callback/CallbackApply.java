/**
 * File CallbackApply
 *
 * Author d.a.ganzha
 * Project mvp-architecture
 * Created by 07.10.18 22:31
 */

package returnt.ru.mvparchitecture.callback;

/**
 * Class CallbackApply
 *
 * Author d.a.ganzha
 * Package returnt.ru.mvparchitecture.callback
 * Created by 07.10.18 22:31
 */
public interface CallbackApply<T> {

    /**
     * apply to object t
     *
     * @param t
     */
    void apply(T t);
}
