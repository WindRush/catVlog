package com.lasingwu.baselibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;




public interface IImageLoaderstrategy {
    void showImage(@NonNull ImageLoaderOptions options);
    void hideImage(@NonNull View view,int visiable);
    void cleanMemory(Context context);
    void pause(Context context);
    void resume(Context context);
    // 在application的oncreate中初始化
    void init(Context context,ImageLoaderConfig config);
}
