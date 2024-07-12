package com.example.feature.model

import com.example.feature.R

enum class NavigationMenuItem(val icon: Int,val nameItem : String,val isCurrentMenu: Boolean) {
    ALL_TASKS(R.drawable.baseline_checklist_24, "All Tasks", true),
    TODAY_TASKS(R.drawable.baseline_today_24, "Today", false),
    SCHEDULED_TASKS(R.drawable.baseline_schedule_24, "Scheduled", false),
    IMPORTANT_TASK(R.drawable.baseline_star_border_24, "Important", false),
    COMPLETED_TASK(R.drawable.baseline_check_24, "Completed", false),
    DELETED_TASK(R.drawable.baseline_delete_outline_24, "Trash", false),
}