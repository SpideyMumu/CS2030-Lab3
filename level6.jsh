void serveCruises(List<Cruise> cruises) {
   // create empty ImList of loaders
   ImList<Loader> loaders = new ImList<Loader>();
   
   for(int i = 0; i < cruises.size(); i++) {
       if(cruises.get(i).getNumOfLoadersRequired() > 1) { // this is to serve Big Cruise
           for(int j = 0; j < cruises.get(i).getNumOfLoadersRequired(); j++) {
               loaders = addLoaders(loaders, cruises.get(i));
            }
       } else { // this is to serve Small Cruise   
           loaders = addLoaders(loaders, cruises.get(i));
       }     
   }
} 
 

ImList<Loader> addLoaders(ImList<Loader> loaders, Cruise cruise) {

    // add first loader if ImList is empty
    if(loaders.size() == 0) {
        System.out.println(new Loader(1, cruise));
        return loaders.add(new Loader(1, cruise));
    } 
    
    // check if any current loaders are available to serve
    for (int i = 0; i < loaders.size(); i++) {
           if(loaders.get(i).canServe(cruise)) {
               System.out.println(loaders.get(i).serve(cruise));
               return loaders.set(i, loaders.get(i).serve(cruise));
            }
        }
        
     // purchase new loader if all current loaders are not available
     if((loaders.size() + 1) % 3 == 0) {
        System.out.println(new RecycledLoader(loaders.size() + 1, cruise));
        return loaders.add(new RecycledLoader(loaders.size() + 1, cruise));
      
     } else {
        System.out.println(new Loader(loaders.size() + 1, cruise));
        return loaders.add(new Loader(loaders.size() + 1, cruise));
     }
}
