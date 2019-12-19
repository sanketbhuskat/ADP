
1)Start java Application
2)Using postman you can hit below rest API to create and get product and category

Basic auth-
userName-user
password-admin

POST  http://localhost:8090/checkoutcounter/category
{
	"name": "Z",
	"salesTaxPercentage": "50"
}
GET http://localhost:8090/checkoutcounter/category/{id}
GET http://localhost:8090/checkoutcounter/category/all


POST  http://localhost:8090/checkoutcounter/product
{
	"name": "grapes",
	"cost": "50",
	"category": "Z"
}
GET  http://localhost:8090/checkoutcounter/product
GET  http://localhost:8090/checkoutcounter/product/all


3) you can genrate bill and get bill for product using below apis

POST  http://localhost:8090/checkoutcounter/bill
{
	"purchase": [{
		"productName": "apple",
		"quantity": "2"
	}, {
		"productName": "banana",
		"quantity": "1"
	}, {
		"productName": "cherry",
		"quantity": "2"
	}]
}
GET  http://localhost:8090/checkoutcounter/bill/{id}
GET  http://localhost:8090/checkoutcounter/bill/all

3) mokito test cases are also written for above apis

