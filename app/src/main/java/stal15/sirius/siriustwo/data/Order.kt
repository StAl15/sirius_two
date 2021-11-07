package stal15.sirius.siriustwo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_table")
data class Order (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val city: String,
    val street: String,
    val house: String,
    val corpus: String,
    val flat: String,
    val price: Int
    )
