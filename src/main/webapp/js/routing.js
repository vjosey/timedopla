(function () {

    var partialsCache = {}
  

    function fetchFile(path, callback){
  
      
      var request = new XMLHttpRequest();
  

      request.onload = function () {
        callback(request.responseText);
      };
  
   
      request.open("GET", path);
      request.send(null);
    }
  

    function getContent(fragmentId, callback){
  

      if(partialsCache[fragmentId]) {
 
        callback(partialsCache[fragmentId]);
  
      } else {
      
        fetchFile(fragmentId + ".html", function (content) {
  
        
          partialsCache[fragmentId] = content;
  
          
          callback(content);
        });
      }
    }
  

    // Updates dynamic content based on the fragment identifier.
    function navigate(){
  
      // Get a reference to the "content" div.
      var contentDiv = document.getElementById("main"),
  
          // Isolate the fragment identifier using substr.
          // This gets rid of the "#" character.
          fragmentId = location.hash.substr(1);
  
      
      getContent(fragmentId, function (content) {
        contentDiv.innerHTML = content;
      });
  
    }
  
    // If no fragment identifier is provided,
    if(!location.hash) {
  
      // default to #home.
      location.hash = "#login";
    }

    navigate();
  
    // Navigate whenever the fragment identifier value changes.
    window.addEventListener("hashchange", navigate)
  }());