/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

var module = angular.module('SeminarApp', ['ngResource', 'ngStorage']);


module.factory('registerDAO', function ($resource) {
    return $resource('/api/register');
});

module.factory('signInDAO', function ($resource) {
    return $resource('/api/staff/:username');
});


module.controller('StaffController', function (registerDAO, signInDAO, $window, $sessionStorage) {
    this.signInMessage = "Please sign in to continue.";
    this.registerStaff = function (staff) {
        registerDAO.save(null, staff,
                // success callback
                        function () {
                            $window.location = 'sign-in.html';
                        },
                        // error callback
                                function (error) {
                                    console.log(error);
                                }
                        );
                    };

            // alias 'this' so that we can access it inside callback functions
            let ctrl = this;
            this.signIn = function (username, password) {
                // get staff from web service
                signInDAO.get({'username': username},
                        // success
                                function (staff) {
                                    // also store the retrieved customer
                                    $sessionStorage.staff = staff;
                                    // redirect to home
                                    $window.location.href = 'index.html';
                                },
                                // fail
                                        function () {
                                            ctrl.signInMessage = 'Sign in failed. Please try again.';
                                        }
                                );
                            };
                    this.checkSignIn = function () {
                        // has the customer been added to the session?
                        if ($sessionStorage.staff) {
                            this.signedIn = true;
                            this.welcome = "Welcome " + $sessionStorage.staff.firstName;//could be issue with upper case N
                        } else {
                            this.signedIn = false;
                        }
                    };
                    this.signOut = function () {
                        this.signedIn = false;
                        $window.location.href = 'sign-in.html';
                        $sessionStorage.$reset();
                    };
                });

        module.factory('registerSeminarDAO', function ($resource) {
            return $resource('/api/seminars/register');
        });
        
        
        module.controller('SeminarController', function (registerSeminarDAO, $window) {
            this.registerSeminar = function (seminar) {
                registerSeminarDAO.save(null, seminar,
                        // success callback
                                function () {
                                    $window.location = 'index.html';
                                },
                                // error callback
                                        function (error) {
                                            console.log(error);
                                        }
                                );
                            };
                });

        module.factory('seminarDAO', function ($resource) {
            return $resource('/api/seminars');
        });


        module.controller('AllSeminarController', function (seminarDAO) {
            this.seminars = seminarDAO.query();
        });
