import Axios from 'axios';

export function getData() {
	setInterval(function () {
		Axios.get('./pos/1/order').then(function (response) {
			this.orderList = response.data;
		});
		
		Axios.get('./pos/1/cashbook').then(function (response) {
			this.cashBook = response.data;
		});
		
		Axios.get('./pos/1/menu').then(function (response) {
			this.menu = response.data;
		});
		
		Axios.get('./pos/1/invoice').then(function (response) {
			this.invoice = response.data;
		});
		
		Axios.get('./pos/1/reservation').then(function (response) {
			this.reservation = response.data;
		});
		
		Axios.get('./pos/1/table').then(function (response) {
			this.table = response.data;
		});
		
	}, 3000);
}

export function getOrder(pos_seq) {
	return Axios.get('./pos/'+pos_seq+'/order');
}
