package fh_campus.data.models

import fh_campus.utils.getDate
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Goals : Table() {
    val goalId = long("goalId").autoIncrement().primaryKey()
    val goal = text("goal")
    val description = text("description")

    val startDate = long("startDate").default(getDate().timeInMillis)

    val endDate = long("endDate").nullable()


    fun toGoal(row: ResultRow): Goal = Goal(
        goalId = row[goalId],
        goal = row[goal],
        description = row[description],
        startDate = row[startDate],
        endDate = row[endDate],
    )
}

data class Goal(
    val goalId: Long = 0,
    val goal: String,
    val description: String,
    val startDate: Long,
    val endDate: Long? = null,
) {
    override fun toString(): String {
        return "$goalId $goal $description"
    }
}