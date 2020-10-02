let app = function (){
    const login = (username,password) =>{
        console.log(username,password);
        const user={username:username,password:password}
        axios.post('/login',user).then(res=>{
            if(res.data !== ''){
                window.location.href = 'secure/index.html';
            }else{
                alert(res.data);
            }
        })
    };
    return {
        login: login
    };
}();
