/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import org.jooby.Results;

/**
 *
 * @author wiljo912
 */
public class AssetModule extends Jooby {

    public AssetModule() {
        assets("/menu.html");
        assets("/create-account.html");
        assets("/create-seminar.html");
        assets("/index.html");
        assets("/profile.html");
        assets("/sign-in.html");
        
        
        assets("/css/homepage.css");
        assets("/css/index.css");
        assets("/css/profile.css");
        
        assets("js/angular.min.js");
        assets("js/angular-resource.min.js");
        assets("js/ngStorage.min.js");
        assets("/js/seminarmanager.js");
        
        
        assets("/images/uni-logo.png");
        assets("/images/*.jpg");
        
        
        // make index.html the default page
        assets("/", "sign-in.html");
        // prevent 404 errors due to browsers requesting favicons
        get("/favicon.ico", () -> Results.noContent());
    }
}
