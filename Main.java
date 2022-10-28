package com.isupov.mywork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int inputNum = 0;

    public static void main(String[] args) {
        run();
    }
        public static void run () {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.isupov.mywork");
            ProductRepository productRepository = context.getBean(ProductRepository.class);
            productRepository.getProductsHolder().stream().forEach(System.out::println);
            Cart cart = null;
            while (true) {
                if (inputNum == 99) {
                    return;
                }
                System.out.println("| 1. Add  ID | | 2. Delete ID | | 3. Print All in Cart | | 4. New Cart | | 5. 99 for exit |");
                enterNumber();
                switch (inputNum) {
                    case (1):
                        System.out.println("1 Enter ID for search");
                        enterNumber();
                        if (cart == null) {
                            cart = context.getBean(Cart.class);
                        }
                        if (productRepository.getProduct(inputNum).isPresent()) {
                            cart.addToCart(productRepository.getProduct(inputNum).get());
                            System.out.println("add product ID: " + inputNum + " to cart");
                            break;
                        }
                        System.out.println(inputNum + " ID Not found");
                        break;
                    case (2):
                        System.out.println("2 Enter id");
                        enterNumber();
                        if (cart.deleteFromCart(inputNum)) {
                            System.out.println(inputNum + "Product delete from cart");
                        } else {
                            System.out.println(inputNum + " not found");
                        }
                        break;
                    case (3):
                        System.out.println("In Cart: ");
                        cart.showCart();
                        break;
                    case (4):
                        cart = context.getBean(Cart.class);
                        break;
                    case (99):
                        System.out.println("5 Shutdown");
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
            }
        }

        public static void enterNumber () {
            while (!sc.hasNextInt()) {
                System.out.println("Wrong input!");
                sc.next();
            }
            inputNum = sc.nextInt();
        }

    }


