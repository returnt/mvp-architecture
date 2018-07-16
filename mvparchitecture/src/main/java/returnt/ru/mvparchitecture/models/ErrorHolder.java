/**
 * File ErrorHolder
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.models
 * Created by 01.07.2017
 */

package returnt.ru.mvparchitecture.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Class ErrorHolder
 *
 * Author d.a.ganzha
 * Package returnt.rxmodule.models
 * Created by 01.07.2017
 */
public class ErrorHolder<T> implements Serializable, Parcelable {

    @SerializedName("code")
    @Expose
    Integer code;
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("errors")
    @Expose
    T mErrors;
    private Throwable throwable;

    public ErrorHolder() {
    }

    public ErrorHolder(Throwable throwable) {
        this.throwable = throwable;
        this.message = throwable.getMessage();
    }

    protected ErrorHolder(Parcel in) {
        if (in.readByte() == 0) {
            code = null;
        } else {
            code = in.readInt();
        }
        message = in.readString();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getErrors() {
        return mErrors;
    }

    public void setErrors(T errors) {
        mErrors = errors;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public static final Creator<ErrorHolder> CREATOR = new Creator<ErrorHolder>() {
        @Override
        public ErrorHolder createFromParcel(Parcel in) {
            return new ErrorHolder(in);
        }

        @Override
        public ErrorHolder[] newArray(int size) {
            return new ErrorHolder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (code == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(code);
        }
        dest.writeString(message);
    }
}
