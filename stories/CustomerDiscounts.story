
import org.acme.app.Customer
import org.acme.app.Item
import org.acme.app.ShoppingCart
import org.acme.app.CouponService


before_each "initialize a Non-Gold level customer", {
 given "a non-Gold level customer", {
  customer = new Customer()
  customer.goldLevel = false
 }
}


scenario "Non-Gold level customer with \$100 or more" , {

 when "they have \$100 or more in their shopping cart", {
   shoppingCart = new ShoppingCart()
   shoppingCart.addItem(new Item("Foo", 101.00))

   customer.shoppingCart = shoppingCart
 }
 then "at the time of checkout, they should receive \$10 off the total price", {
   customer.checkOut()

   customer.orderPrice().shouldBe 91.00

 }
 and "they should be emailed a coupon within 24 hours", {
   CouponService.scheduleDiscountEmail(customer)
   CouponService.scheduledEmails.shouldHave customer
 }
}


scenario "Non-Gold level customer with less than \$100", {
 
 when "they have less than \$100 in their shopping cart", {
   shoppingCart = new ShoppingCart()
   shoppingCart.addItem(new Item("Foo", 99.00))

   customer.shoppingCart = shoppingCart
 }
 then "at the time of checkout, they should not receive any discounts", {
   customer.checkOut()

   customer.orderPrice().shouldBe 99.00
 }
 and "they should not be emailed a coupon", {
  CouponService.scheduledEmails.shouldNotHave customer
 }
}