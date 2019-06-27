package com.casstime.route.face;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/**
 * Created by maiwenchang at 2019-06-18 16:20
 * Description ：对ARouter的Postcard进行封装
 */
public interface ICTPostcard {

    Bundle getOptionsBundle();

    int getEnterAnim();

    int getExitAnim();

    ICTProvider getProvider();

    ICTPostcard setProvider(ICTProvider provider);

    boolean isGreenChannel();

    Object getTag();

    ICTPostcard setTag(Object tag);

    Bundle getExtras();

    int getTimeout();

    /**
     * Set timeout of navigation this time.
     *
     * @param timeout timeout
     * @return this
     */
    ICTPostcard setTimeout(int timeout);

    Uri getUri();

    ICTPostcard setUri(Uri uri);

    /**
     * Navigation to the route with path in ARouterPostcard.
     * No param, will be use application context.
     */
    Object navigation();

    /**
     * Navigation to the route with path in postcard.
     *
     * @param context Activity and so on.
     */
    Object navigation(Context context);

    /**
     * Navigation to the route with path in postcard.
     *
     * @param context Activity and so on.
     */
    Object navigation(Context context, CTNavigationCallback callback);

    /**
     * Navigation to the route with path in postcard.
     *
     * @param mContext    Activity and so on.
     * @param requestCode startActivityForResult's param
     */
    void navigation(Activity mContext, int requestCode);

    /**
     * Navigation to the route with path in postcard.
     *
     * @param mContext    Activity and so on.
     * @param requestCode startActivityForResult's param
     */
    void navigation(Activity mContext, int requestCode, CTNavigationCallback callback);

    /**
     * Green channel, it will skip all of interceptors.
     *
     * @return this
     */
    ICTPostcard greenChannel();

    /**
     * BE ATTENTION TO THIS METHOD WAS <P>SET, NOT ADD!</P>
     */
    ICTPostcard with(Bundle bundle) ;

    @IntDef({
            Intent.FLAG_ACTIVITY_SINGLE_TOP,
            Intent.FLAG_ACTIVITY_NEW_TASK,
            Intent.FLAG_GRANT_WRITE_URI_PERMISSION,
            Intent.FLAG_DEBUG_LOG_RESOLUTION,
            Intent.FLAG_FROM_BACKGROUND,
            Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT,
            Intent.FLAG_ACTIVITY_CLEAR_TASK,
            Intent.FLAG_ACTIVITY_CLEAR_TOP,
            Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS,
            Intent.FLAG_ACTIVITY_FORWARD_RESULT,
            Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY,
            Intent.FLAG_ACTIVITY_MULTIPLE_TASK,
            Intent.FLAG_ACTIVITY_NO_ANIMATION,
            Intent.FLAG_ACTIVITY_NO_USER_ACTION,
            Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP,
            Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED,
            Intent.FLAG_ACTIVITY_REORDER_TO_FRONT,
            Intent.FLAG_ACTIVITY_TASK_ON_HOME,
            Intent.FLAG_RECEIVER_REGISTERED_ONLY
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface FlagInt {
    }

    /**
     * Set special flags controlling how this intent is handled.  Most values
     * here depend on the type of component being executed by the Intent,
     * specifically the FLAG_ACTIVITY_* flags are all for use with
     * {@link Context#startActivity Context.startActivity()} and the
     * FLAG_RECEIVER_* flags are all for use with
     * {@link Context#sendBroadcast(Intent) Context.sendBroadcast()}.
     */
    ICTPostcard withFlags(@ICTPostcard.FlagInt int flag);

    int getFlags();

    /**
     * Set object value, the value will be convert to string by 'Fastjson'
     *
     * @param key   a String, or null
     * @param value a Object, or null
     * @return current
     */
    ICTPostcard withObject(@Nullable String key, @Nullable Object value);

    // Follow api copy from #{Bundle}

    /**
     * Inserts a String value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a String, or null
     * @return current
     */
    ICTPostcard withString(@Nullable String key, @Nullable String value);

    /**
     * Inserts a Boolean value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a boolean
     * @return current
     */
    ICTPostcard withBoolean(@Nullable String key, boolean value);

    /**
     * Inserts a short value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a short
     * @return current
     */
    ICTPostcard withShort(@Nullable String key, short value);

    /**
     * Inserts an int value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value an int
     * @return current
     */
    ICTPostcard withInt(@Nullable String key, int value);

    /**
     * Inserts a long value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a long
     * @return current
     */
    ICTPostcard withLong(@Nullable String key, long value);

    /**
     * Inserts a double value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a double
     * @return current
     */
    ICTPostcard withDouble(@Nullable String key, double value);

    /**
     * Inserts a byte value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a byte
     * @return current
     */
    ICTPostcard withByte(@Nullable String key, byte value);

    /**
     * Inserts a char value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a char
     * @return current
     */
    ICTPostcard withChar(@Nullable String key, char value);

    /**
     * Inserts a float value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a float
     * @return current
     */
    ICTPostcard withFloat(@Nullable String key, float value);

    /**
     * Inserts a CharSequence value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a CharSequence, or null
     * @return current
     */
    ICTPostcard withCharSequence(@Nullable String key, @Nullable CharSequence value);

    /**
     * Inserts a Parcelable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Parcelable object, or null
     * @return current
     */
    ICTPostcard withParcelable(@Nullable String key, @Nullable Parcelable value);

    /**
     * Inserts an array of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key   a String, or null
     * @param value an array of Parcelable objects, or null
     * @return current
     */
    ICTPostcard withParcelableArray(@Nullable String key, @Nullable Parcelable[] value);

    /**
     * Inserts a List of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList of Parcelable objects, or null
     * @return current
     */
    ICTPostcard withParcelableArrayList(@Nullable String key, @Nullable ArrayList<? extends Parcelable> value);

    /**
     * Inserts a SparceArray of Parcelable values into the mapping of this
     * Bundle, replacing any existing value for the given key.  Either key
     * or value may be null.
     *
     * @param key   a String, or null
     * @param value a SparseArray of Parcelable objects, or null
     * @return current
     */
    ICTPostcard withSparseParcelableArray(@Nullable String key, @Nullable SparseArray<? extends Parcelable> value);

    /**
     * Inserts an ArrayList value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList object, or null
     * @return current
     */
    ICTPostcard withIntegerArrayList(@Nullable String key, @Nullable ArrayList<Integer> value);

    /**
     * Inserts an ArrayList value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList object, or null
     * @return current
     */
    ICTPostcard withStringArrayList(@Nullable String key, @Nullable ArrayList<String> value);

    /**
     * Inserts an ArrayList value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList object, or null
     * @return current
     */
    ICTPostcard withCharSequenceArrayList(@Nullable String key, @Nullable ArrayList<CharSequence> value);

    /**
     * Inserts a Serializable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Serializable object, or null
     * @return current
     */
    ICTPostcard withSerializable(@Nullable String key, @Nullable Serializable value);

    /**
     * Inserts a byte array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a byte array object, or null
     * @return current
     */
    ICTPostcard withByteArray(@Nullable String key, @Nullable byte[] value);

    /**
     * Inserts a short array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a short array object, or null
     * @return current
     */
    ICTPostcard withShortArray(@Nullable String key, @Nullable short[] value);

    /**
     * Inserts a char array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a char array object, or null
     * @return current
     */
    ICTPostcard withCharArray(@Nullable String key, @Nullable char[] value);

    /**
     * Inserts a float array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a float array object, or null
     * @return current
     */
    ICTPostcard withFloatArray(@Nullable String key, @Nullable float[] value);

    /**
     * Inserts a CharSequence array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a CharSequence array object, or null
     * @return current
     */
    ICTPostcard withCharSequenceArray(@Nullable String key, @Nullable CharSequence[] value);

    /**
     * Inserts a Bundle value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Bundle object, or null
     * @return current
     */
    ICTPostcard withBundle(@Nullable String key, @Nullable Bundle value);

    /**
     * Set normal transition anim
     *
     * @param enterAnim enter
     * @param exitAnim  exit
     * @return current
     */
    ICTPostcard withTransition(int enterAnim, int exitAnim);

    /**
     * Set options compat
     *
     * @param compat compat
     * @return this
     */
    @RequiresApi(16)
    ICTPostcard withOptionsCompat(ActivityOptionsCompat compat);

}
