package com.demo.widgets.widgets.collections

enum class CollectionType(val value: Int) {

    STACK(0),
    FLIPPER(1),
    LIST(2),
    GRID(3),
    ;

    companion object {

        val DEFAULT = STACK

        const val SP_KEY = "collection_type"
        fun valueOf(value: Int): CollectionType? {
            return entries.find {
                it.value == value
            }
        }

        fun contains(int: Int): Boolean {
            return entries.find {
                it.value == int
            } != null
        }

        fun contains(type: CollectionType): Boolean {
            return entries.toTypedArray().contains(type)
        }
    }
}
