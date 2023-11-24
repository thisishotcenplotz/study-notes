package com.george.chapter07.abstractdemo

object BankDemo {
  def main(args: Array[String]): Unit = {
    val account = new Account("chase00001", 99999.99, "password")

    println(account.checkBalance("password"))
    println(account.withdraw("password", 100))
    println(account.checkBalance("password"))
    println(account.deposit("password", 50000))
    println(account.checkBalance("password"))





  }
}

class Account(inAccountNumber:String, inBalance:Double, inPassword:String) {
  // properties: account, balance, password
  private val accountNumber: String = inAccountNumber
  private var balance: Double = inBalance
  private var password: String = inPassword

  // methods: checkBalance, withdraw, deposit
  def checkBalance(password:String): String = {
    if (this.password.equals(password)){
      return s"your balance is:${this.balance}"
    }else{
      return "Wrong password!"
    }
  }

  def withdraw(password:String,amount:Double): String = {
    if (this.password.equals(password)) {
      if(amount <= this.balance){
        this.balance -= amount
        return s"${amount} 取款成功；当前账户余额${this.balance}"
      }else{
        return s"账户余额不足以取款${amount}"
      }
    } else {
      return "Wrong password!!"
    }
  }

  def deposit(password:String,amount:Double): Any = {
    if (this.password.equals(password)) {
      this.balance += amount
      return s"${amount} 存款成功；当前账户余额${this.balance}"
    } else {
      return "Wrong password!!"
    }
  }


}
