package ge.android.tsu.project1.data;

import android.content.Context;

public interface  Storage1 {
    void save(Context context, String key, String value);

    String get(Context context, String key);

    boolean exists(Context context, String key);



}
