package com.example.a15_recyclerview_foreground_and_background_cell_java.helper;

import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a15_recyclerview_foreground_and_background_cell_java.adapter.CustomAdapter;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    public RecyclerItemTouchHelperListener listener;

    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder,int actionState){
        if(viewHolder != null){
            final View foregroundView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;

            getDefaultUIUtil().onSelected(foregroundView);
        }
    }

    @Override
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder,float dX,float dY,int actionState, boolean isCurrentlyActive){
        final  View foregroundView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;

        getDefaultUIUtil().onDrawOver(canvas,recyclerView,foregroundView,dX/3,dY,actionState,isCurrentlyActive);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder){
        final  View foregroundView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;
        getDefaultUIUtil().clearView(foregroundView);
    }

    @Override
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder,float dX,float dY,int actionState, boolean isCurrentlyActive){
        final  View foregroundView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;

        getDefaultUIUtil().onDraw(canvas,recyclerView,foregroundView,dX/3,dY,actionState,isCurrentlyActive);
    }


    @Override
    public int convertToAbsoluteDirection(int flags, int LayoutDirection){
        return super.convertToAbsoluteDirection(flags,LayoutDirection);
    }



    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction){
        listener.onSwiped(viewHolder,direction,viewHolder.getAdapterPosition());
    }

    public interface RecyclerItemTouchHelperListener {
        void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
    }
}
