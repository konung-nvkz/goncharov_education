package com.catboy.goncharov_edu.screens

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.catboy.goncharov_edu.R
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.presenters.TaskListPresenter

class TaskListAdapter(private val context: Context, private val tasks: ArrayList<Task>) :
    RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val presenter = TaskListPresenter(context)

        val taskItem = tasks[position]
        holder.title.text = taskItem.title
        holder.text.text = taskItem.text
        holder.status.text = taskItem.status.toString()

        holder.update.setOnClickListener { presenter.update(position) }
        holder.delete.setOnClickListener { presenter.delete(this, position) }

    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun delete(index: Int) {
        tasks.removeAt(index)
        //notifyItemRemoved(index)
        notifyDataSetChanged()
    }

    fun deleteLast() {
        tasks.removeAt(tasks.size - 1)
        notifyItemRemoved(tasks.size)
    }

    fun deleteAll() {
        tasks.clear()
        notifyDataSetChanged()
    }

    class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val text: TextView = view.findViewById(R.id.text)
        val status: TextView = view.findViewById(R.id.status)
        val update: TextView = view.findViewById(R.id.update)
        val delete: TextView = view.findViewById(R.id.delete)

    }

}
