package main

import (
	"fmt"
	"yourpackagepath/singleton"
)

func main() {
	singleton1 := singleton.GetInstance()
	singleton2 := singleton.GetInstance()

	// Check if both instances are the same
	fmt.Println(singleton1 == singleton2) // Output: true
}
