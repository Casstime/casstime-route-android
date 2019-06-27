package com.casstime.route.arouter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.casstime.route.face.CTNavigationCallback;
import com.casstime.route.face.ICTPostcard;
import com.casstime.route.face.ICTProvider;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by maiwenchang at 2019-06-18 16:27
 * Description ：对postcard的封装
 */
public class CTARouterPostcard implements ICTPostcard {

    private Postcard mPostcard;

    public CTARouterPostcard(Postcard postcard) {
        mPostcard = postcard;
    }

    Postcard getPostcard() {
        return mPostcard;
    }

    public Bundle getOptionsBundle() {
        return mPostcard.getOptionsBundle();
    }

    public int getEnterAnim() {
        return mPostcard.getEnterAnim();
    }

    public int getExitAnim() {
        return mPostcard.getExitAnim();
    }

    public ICTProvider getProvider() {
        return (ICTProvider) mPostcard.getProvider();
    }

    public CTARouterPostcard setProvider(ICTProvider provider) {
        mPostcard.setProvider(provider);
        return this;
    }

    public boolean isGreenChannel() {
        return mPostcard.isGreenChannel();
    }

    public Object getTag() {
        return mPostcard.getTag();
    }

    public CTARouterPostcard setTag(Object tag) {
        mPostcard.setTag(tag);
        return this;
    }

    public Bundle getExtras() {
        return mPostcard.getExtras();
    }

    public int getTimeout() {
        return mPostcard.getTimeout();
    }

    /**
     * Set timeout of navigation this time.
     *
     * @param timeout timeout
     * @return this
     */
    public CTARouterPostcard setTimeout(int timeout) {
        mPostcard.setTimeout(timeout);
        return this;
    }

    public Uri getUri() {
        return mPostcard.getUri();
    }

    public CTARouterPostcard setUri(Uri uri) {
        mPostcard.setUri(uri);
        return this;
    }

    /**
     * Navigation to the route with path in ARouterPostcard.
     * No param, will be use application context.
     */
    public Object navigation() {
        return navigation(null);
    }

    /**
     * Navigation to the route with path in postcard.
     *
     * @param context Activity and so on.
     */
    public Object navigation(Context context) {
        return navigation(context, null);
    }

    /**
     * Navigation to the route with path in postcard.
     *
     * @param context Activity and so on.
     */
    public Object navigation(Context context, CTNavigationCallback callback) {
        return ARouter.getInstance().navigation(context, mPostcard, -1, new ARouterNavCallBack(callback));
    }

    /**
     * Navigation to the route with path in postcard.
     *
     * @param mContext    Activity and so on.
     * @param requestCode startActivityForResult's param
     */
    public void navigation(Activity mContext, int requestCode) {
        navigation(mContext, requestCode, null);
    }

    /**
     * Navigation to the route with path in postcard.
     *
     * @param mContext    Activity and so on.
     * @param requestCode startActivityForResult's param
     */
    public void navigation(Activity mContext, int requestCode, CTNavigationCallback callback) {
        ARouter.getInstance().navigation(mContext, mPostcard, requestCode, new ARouterNavCallBack(callback));
    }

    /**
     * Green channel, it will skip all of interceptors.
     *
     * @return this
     */
    public CTARouterPostcard greenChannel() {
        mPostcard.greenChannel();
        return this;
    }

    /**
     * BE ATTENTION TO THIS METHOD WAS <P>SET, NOT ADD!</P>
     */
    public CTARouterPostcard with(Bundle bundle) {
        if (null != bundle) {
            mPostcard.with(bundle);
        }
        return this;
    }

    /**
     * Set special flags controlling how this intent is handled.  Most values
     * here depend on the type of component being executed by the Intent,
     * specifically the FLAG_ACTIVITY_* flags are all for use with
     * {@link Context#startActivity Context.startActivity()} and the
     * FLAG_RECEIVER_* flags are all for use with
     * {@link Context#sendBroadcast(Intent) Context.sendBroadcast()}.
     */
    public CTARouterPostcard withFlags(@FlagInt int flag) {
        mPostcard.withFlags(flag);
        return this;
    }

    public int getFlags() {
        return mPostcard.getFlags();
    }

    /**
     * Set object value, the value will be convert to string by 'Fastjson'
     *
     * @param key   a String, or null
     * @param value a Object, or null
     * @return current
     */
    public CTARouterPostcard withObject(@Nullable String key, @Nullable Object value) {
        mPostcard.withObject(key, value);
        return this;
    }

    // Follow api copy from #{Bundle}

    /**
     * Inserts a String value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a String, or null
     * @return current
     */
    public CTARouterPostcard withString(@Nullable String key, @Nullable String value) {
        mPostcard.withString(key, value);
        return this;
    }

    /**
     * Inserts a Boolean value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a boolean
     * @return current
     */
    public CTARouterPostcard withBoolean(@Nullable String key, boolean value) {
        mPostcard.withBoolean(key, value);
        return this;
    }

    /**
     * Inserts a short value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a short
     * @return current
     */
    public CTARouterPostcard withShort(@Nullable String key, short value) {
        mPostcard.withShort(key, value);
        return this;
    }

    /**
     * Inserts an int value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value an int
     * @return current
     */
    public CTARouterPostcard withInt(@Nullable String key, int value) {
        mPostcard.withInt(key, value);
        return this;
    }

    /**
     * Inserts a long value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a long
     * @return current
     */
    public CTARouterPostcard withLong(@Nullable String key, long value) {
        mPostcard.withLong(key, value);
        return this;
    }

    /**
     * Inserts a double value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a double
     * @return current
     */
    public CTARouterPostcard withDouble(@Nullable String key, double value) {
        mPostcard.withDouble(key, value);
        return this;
    }

    /**
     * Inserts a byte value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a byte
     * @return current
     */
    public CTARouterPostcard withByte(@Nullable String key, byte value) {
        mPostcard.withByte(key, value);
        return this;
    }

    /**
     * Inserts a char value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a char
     * @return current
     */
    public CTARouterPostcard withChar(@Nullable String key, char value) {
        mPostcard.withChar(key, value);
        return this;
    }

    /**
     * Inserts a float value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a float
     * @return current
     */
    public CTARouterPostcard withFloat(@Nullable String key, float value) {
        mPostcard.withFloat(key, value);
        return this;
    }

    /**
     * Inserts a CharSequence value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a CharSequence, or null
     * @return current
     */
    public CTARouterPostcard withCharSequence(@Nullable String key, @Nullable CharSequence value) {
        mPostcard.withCharSequence(key, value);
        return this;
    }

    /**
     * Inserts a Parcelable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Parcelable object, or null
     * @return current
     */
    public CTARouterPostcard withParcelable(@Nullable String key, @Nullable Parcelable value) {
        mPostcard.withParcelable(key, value);
        return this;
    }

    /**
     * Inserts an array of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key   a String, or null
     * @param value an array of Parcelable objects, or null
     * @return current
     */
    public CTARouterPostcard withParcelableArray(@Nullable String key, @Nullable Parcelable[] value) {
        mPostcard.withParcelableArray(key, value);
        return this;
    }

    /**
     * Inserts a List of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList of Parcelable objects, or null
     * @return current
     */
    public CTARouterPostcard withParcelableArrayList(@Nullable String key, @Nullable ArrayList<? extends Parcelable> value) {
        mPostcard.withParcelableArrayList(key, value);
        return this;
    }

    /**
     * Inserts a SparceArray of Parcelable values into the mapping of this
     * Bundle, replacing any existing value for the given key.  Either key
     * or value may be null.
     *
     * @param key   a String, or null
     * @param value a SparseArray of Parcelable objects, or null
     * @return current
     */
    public CTARouterPostcard withSparseParcelableArray(@Nullable String key, @Nullable SparseArray<? extends Parcelable> value) {
        mPostcard.withSparseParcelableArray(key, value);
        return this;
    }

    /**
     * Inserts an ArrayList value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList object, or null
     * @return current
     */
    public CTARouterPostcard withIntegerArrayList(@Nullable String key, @Nullable ArrayList<Integer> value) {
        mPostcard.withIntegerArrayList(key, value);
        return this;
    }

    /**
     * Inserts an ArrayList value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList object, or null
     * @return current
     */
    public CTARouterPostcard withStringArrayList(@Nullable String key, @Nullable ArrayList<String> value) {
        mPostcard.withStringArrayList(key, value);
        return this;
    }

    /**
     * Inserts an ArrayList value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList object, or null
     * @return current
     */
    public CTARouterPostcard withCharSequenceArrayList(@Nullable String key, @Nullable ArrayList<CharSequence> value) {
        mPostcard.withCharSequenceArrayList(key, value);
        return this;
    }

    /**
     * Inserts a Serializable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Serializable object, or null
     * @return current
     */
    public CTARouterPostcard withSerializable(@Nullable String key, @Nullable Serializable value) {
        mPostcard.withSerializable(key, value);
        return this;
    }

    /**
     * Inserts a byte array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a byte array object, or null
     * @return current
     */
    public CTARouterPostcard withByteArray(@Nullable String key, @Nullable byte[] value) {
        mPostcard.withByteArray(key, value);
        return this;
    }

    /**
     * Inserts a short array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a short array object, or null
     * @return current
     */
    public CTARouterPostcard withShortArray(@Nullable String key, @Nullable short[] value) {
        mPostcard.withShortArray(key, value);
        return this;
    }

    /**
     * Inserts a char array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a char array object, or null
     * @return current
     */
    public CTARouterPostcard withCharArray(@Nullable String key, @Nullable char[] value) {
        mPostcard.withCharArray(key, value);
        return this;
    }

    /**
     * Inserts a float array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a float array object, or null
     * @return current
     */
    public CTARouterPostcard withFloatArray(@Nullable String key, @Nullable float[] value) {
        mPostcard.withFloatArray(key, value);
        return this;
    }

    /**
     * Inserts a CharSequence array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a CharSequence array object, or null
     * @return current
     */
    public CTARouterPostcard withCharSequenceArray(@Nullable String key, @Nullable CharSequence[] value) {
        mPostcard.withCharSequenceArray(key, value);
        return this;
    }

    /**
     * Inserts a Bundle value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Bundle object, or null
     * @return current
     */
    public CTARouterPostcard withBundle(@Nullable String key, @Nullable Bundle value) {
        mPostcard.withBundle(key, value);
        return this;
    }

    /**
     * Set normal transition anim
     *
     * @param enterAnim enter
     * @param exitAnim  exit
     * @return current
     */
    public CTARouterPostcard withTransition(int enterAnim, int exitAnim) {
        mPostcard.withTransition(enterAnim, exitAnim);
        return this;
    }

    /**
     * Set options compat
     *
     * @param compat compat
     * @return this
     */
    @RequiresApi(16)
    public CTARouterPostcard withOptionsCompat(ActivityOptionsCompat compat) {
        mPostcard.withOptionsCompat(compat);
        return this;
    }

    @Override
    public String toString() {
        return "ARouterPostcard{" +
                "uri=" + getUri() +
                ", tag=" + getTag() +
                ", mBundle=" + getExtras() +
                ", flags=" + getFlags() +
                ", timeout=" + getTimeout() +
                ", provider=" + getProvider() +
                ", greenChannel=" + isGreenChannel() +
                ", optionsCompat=" + getOptionsBundle() +
                ", enterAnim=" + getEnterAnim() +
                ", exitAnim=" + getExitAnim() +
                "}\n" +
                super.toString();
    }


    private class ARouterNavCallBack implements NavigationCallback {

        private CTNavigationCallback callback;

        public ARouterNavCallBack(CTNavigationCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onFound(Postcard postcard) {
            if (callback == null) return;
            callback.onFound(new CTARouterPostcard(postcard));
        }

        @Override
        public void onLost(Postcard postcard) {
            if (callback == null) return;
            callback.onFound(new CTARouterPostcard(postcard));
        }

        @Override
        public void onArrival(Postcard postcard) {
            if (callback == null) return;
            callback.onFound(new CTARouterPostcard(postcard));
        }

        @Override
        public void onInterrupt(Postcard postcard) {
            if (callback == null) return;
            callback.onFound(new CTARouterPostcard(postcard));
        }
    }

}
