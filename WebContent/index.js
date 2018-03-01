function getresult(){
var baseURL="https://developers.zomato.com/api/v2.1/search?entity_id=";
var endurl ="&entity_type=city&q=";	
var apikey="&apikey=69356ad3b4004acc1d25c297342a041a";
var place = document.getElementById('city').value;
let url=''.concat(baseURL,place,endurl,place,apikey);
   fetch(url)
   .then(result=>result.json())
   .then((data)=>{
       document.getElementById('show').innerHTML=renderSearch(data);
   })
}
var nav='<a href="#">Go on Top</a>';
let renderSearch=function(data){
	 let htmlText = '';
	 let sendData='a';
    for ( var i=0;i<data.restaurants.length;i++ ) {    	
        htmlText += '<div class="div-conatiner">';
        htmlText += '<div class="col_sm_4">';
        htmlText += '<p>' + data.restaurants[i].restaurant.name + '</p>';
        htmlText += '<p>Address: ' + data.restaurants[i].restaurant.location.address + '</p>';
        htmlText += '<p> Cuisine type: ' + data.restaurants[i].restaurant.cuisines + '</p>';
        //htmlText += "<img src="+data.restaurants[i].restaurant.thumb+"height='250px' width='250px'alt='image'</img>";
        htmlText += '</div>';
        htmlText += '<br>';
        htmlText += '<button  class="btn btn-primary" onclick="sendResult(\''+data.restaurants[i].restaurant.name+'\',\''+data.restaurants[i].restaurant.location.address+'\',\''+data.restaurants[i].restaurant.cuisines+'\'\)">Add to Favourites</button>'+"<br>";
        htmlText += '<hr>';
    }
document.getElementById('show').insertAdjacentHTML('afterend',nav);
document.getElementById('show').insertAdjacentHTML('afterend',htmlText);
}
function sendResult(name,address,cuisine){
	//console.log(name);
	 var xmlHttp = new XMLHttpRequest();
	 var urlFav= "http://localhost:8087/HungryPoint/fav?name="+name+"&address="+address+"&cuisine="+cuisine;
	// console.log(urlFav);
	 xmlHttp.open("GET",urlFav,true);
	 xmlHttp.send();
}
