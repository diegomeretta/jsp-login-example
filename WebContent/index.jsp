<html>
	<body>
		<h3>Login</h3>  
		<%  
			String profile_msg=(String)request.getAttribute("profile_msg");  
			if(profile_msg!=null){  
				out.print(profile_msg);  
			}  
			String login_msg=(String)request.getAttribute("login_msg");  
			if(login_msg!=null){  
				out.print(login_msg);  
			}  
		 %>  
		 <br/>  
		<form action="login.jsp" method="post">  
			Email:<input type="text" name="email"/><br/><br/>  
			Password:<input type="password" name="pass"/><br/><br/>  
			<input type="submit" value="login"/>
		</form>
	      <div id="vue-app-example">
	         <my-component name="contador1"></my-component>
	      </div>
	            <script src="./vue.global.js"></script>
      <script>
         let myComponent = {
            template:'<button v-on:click="aumentar">Contador en {{ count }}</button>',
            data() {
               return {
                  count: 0
               }
            },
            props: ['name'],
            methods: {
               aumentar: function () {
                    console.log('Se aument� el contador', this.name);
                    this.count++;
               }
            }   
         }

         const app = Vue.createApp({
            components: {
               'my-component': myComponent
            }
         })
         .mount('#vue-app-example')
      </script>
	</body>
</html>