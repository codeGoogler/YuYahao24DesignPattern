package design.yuer.com.yuyahao24designpattern.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ActivityUtils {
    /**
     * skip to @param(cls)，and call @param(aty's) finish() method
     */
    public static void skipActivity(Activity aty, Class<?> cls) {
        showActivity(aty, cls);
        aty.finish();
    }

    /**
     * skip to @param(cls)，and call @param(aty's) finish() method
     */
    public static void skipActivity(Activity aty, Intent it) {
        showActivity(aty, it);
        aty.finish();
    }

    /**
     * skip to @param(cls)，and call @param(aty's) finish() method
     */
    public static void skipActivity(Activity aty, Class<?> cls, Bundle extras) {
        showActivity(aty, cls, extras);
        aty.finish();
    }

    /**
     * show to @param(cls)，but can't finish activity
     */
    public static void showActivity(Context aty, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(aty, cls);
        aty.startActivity(intent);
//        AnimationUtil.showNext(aty);
    }

    /**
     * show to @param(cls)，but can't finish activity
     */
    public static void showActivity(Activity aty, Intent it) {
        aty.startActivity(it);
//        AnimationUtil.showNext(aty);
    }

    /**
     * show to @param(cls)，but can't finish activity
     */
    public static void showActivity(Context aty, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(aty, cls);
        aty.startActivity(intent);
//        AnimationUtil.showNext(aty);
    }
    /**
     * show to @param(cls)，but can't finish activity
     */
    public static void showActivityForResult(Activity aty, Class<?> cls, Bundle bundle, int requestCode) {
    	Intent intent = new Intent();
    	if(bundle!=null){
    		intent.putExtras(bundle);
    	}
    	intent.setClass(aty, cls);
    	aty.startActivityForResult(intent, requestCode);
//    	AnimationUtil.showNext(aty);
    }
    /**
     * show to @param(cls)，but can't finish activity
     */
    public static void showActivityForResult(Activity aty, Class<?> cls, int requestCode) {
    	Intent intent = new Intent();
    	intent.setClass(aty, cls);
    	aty.startActivityForResult(intent, requestCode);
//    	AnimationUtil.showNext(aty);
    }
    
//    public static void openDownLoadService(Context context, String downurl,
//            String tilte) {
//        ServiceConnection conn = new ServiceConnection() {
//
//			@Override
//			public void onServiceDisconnected(ComponentName name) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void onServiceConnected(ComponentName name, IBinder service) {
//				 DownloadBinder binder = (DownloadBinder) service;
//				 binder.start();
//			}
//		};
//        Intent intent = new Intent(context, DownloadService.class);
//        intent.putExtra(DownloadService.BUNDLE_KEY_DOWNLOAD_URL, downurl);
//        intent.putExtra(DownloadService.BUNDLE_KEY_TITLE, tilte);
//        context.startService(intent);
//        context.bindService(intent, conn, Context.BIND_AUTO_CREATE);
//    }


}
