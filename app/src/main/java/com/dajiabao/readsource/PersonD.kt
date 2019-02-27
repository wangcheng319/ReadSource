package com.dajiabao.readsource

/**
 * Created by wangc on 2018/11/14
 * E-MAIL:274281610@QQ.COM
 */
class PersonD(builder: Builder) {
    var name: String? = null
    var age: Int = 0
    var sex: String? = null

    init {
        this.name = builder.name
        this.age = builder.age
        this.sex = builder.sex

    }

    class Builder {
        var name: String? = null
        var age: Int = 0
        var sex: String? = null

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun setSex(sex: String): Builder {
            this.sex = sex
            return this
        }

        fun build(): PersonD {
            return PersonD(this)
        }
    }

    override fun equals(obj: Any?): Boolean {
        return super.equals(obj)
    }
}
