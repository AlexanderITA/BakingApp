package com.example.android.bakingapp.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.example.android.bakingapp.R;

/**
 * Created by Alessandro on 16/05/2018.
 */

public class BakingWidgetProvider extends AppWidgetProvider {

    public static String title;
    public static String listIngredients;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId){

        RemoteViews views = new RemoteViews(context.getPackageName() , R.layout.widget_design);
        if(title == null){
            title = "Baking Widget";
            listIngredients = "Empty";
        }

        views.setTextViewText(R.id.title_widget , title);
        views.setTextViewText(R.id.ingredients_widget ,listIngredients);

       /* Intent sendService = new Intent(context , BakingWidgetService.class);
        views.setRemoteAdapter(R.id.list_widget , sendService); */

        Intent launchApp = new Intent(context, com.example.android.bakingapp.ui.MainActivity.class);
        PendingIntent appPendingIntent = PendingIntent.getActivity(context , 0 , launchApp , android.app.PendingIntent.FLAG_UPDATE_CURRENT);
        views.setPendingIntentTemplate(R.id.ll_widget , appPendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        updateAppWidget(context, appWidgetManager, appWidgetId);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
}
