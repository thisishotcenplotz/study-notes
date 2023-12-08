package com.george.chapter08.traitExample

object Example04 {
  def main(args: Array[String]): Unit = {
    val account = new CheckingAccount(10000.00)
    println(account.deposit(100))
    println(account.withdraw(100))
  }

  class BankAccount(initialBalance: Double) {
    private var balance: Double = initialBalance

    def deposit(amount:Double) = {
      this.balance += amount
      this.balance
    }

    def withdraw(amount:Double):Double = {
      this.balance -= amount
      this.balance
    }
  }

  class CheckingAccount(initialBalance:Double) extends BankAccount(initialBalance){
    override def deposit(amount: Double): Double = super.deposit(amount -1)

    override def withdraw(amount: Double): Double = super.withdraw(amount + 1)
  }

  class SavingAccount(initialBalance:Double) extends BankAccount(initialBalance){
    private var cnt:Int = _

    def earnMonthlyInterest()={
      cnt = 3
      super.deposit(1)
    }

    override def deposit(amount: Double): Double = {
      cnt -= 1
      if(cnt <0) super.deposit(amount -1)
      else super.deposit(amount)
    }

    override def withdraw(amount: Double): Double = {
      cnt -= 1
      if (cnt < 0) super.withdraw(amount + 1)
      else super.withdraw(amount)
    }
  }


}
