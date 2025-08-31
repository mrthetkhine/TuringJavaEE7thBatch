package main

import (
	"errors"
	"fmt"
)

func div(a int, b int) (error, int) {
	if b == 0 {
		return errors.New("Divide by zero"), 0
	} else {
		return nil, a / b
	}

}
func main() {
	err, result := div(10, 0)

	if err == nil {
		fmt.Println(result)
	} else {
		fmt.Println("Error ", err)
	}

}
