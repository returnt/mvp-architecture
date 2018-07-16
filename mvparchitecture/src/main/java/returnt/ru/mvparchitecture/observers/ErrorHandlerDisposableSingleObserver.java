/**
 * File ErrorHandlerDisposableSingleObserver
 *
 * Author d.a.ganzha
 * Project android-free
 * Created by 02.07.18 11:21
 */

package returnt.ru.mvparchitecture.observers;

import android.util.Log;
import com.google.gson.Gson;
import io.reactivex.observers.DisposableSingleObserver;
import returnt.ru.mvparchitecture.models.ErrorHolder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class ErrorHandlerDisposableSingleObserver
 *
 * Author d.a.ganzha
 * Project android-free
 * Package returnt.rxmodule.observer
 * Created by 02.07.18 11:21
 */
public abstract class ErrorHandlerDisposableSingleObserver<T, E extends ErrorHolder> extends DisposableSingleObserver<T> {

    private static final String TAG = "ErrorHandlerDisposableS";

    private final Pattern pattern = Pattern.compile("\\|\\|(.+)");

    public abstract void onError(E errorFromServer);

    @Override
    public void onError(Throwable e) {
        E e1 = (E) new ErrorHolder(e);
        try {
            Matcher matcher = pattern.matcher(e.getMessage());
            if (matcher.find()) {
                e1 = (E) new Gson().fromJson(matcher.group(1), ErrorHolder.class);
                e1.setThrowable(e);
            }
        } catch (Exception e2) {
            Log.e(TAG, "onError convert error: ", e);
        } finally {
            onError(e1);
        }
    }
}
