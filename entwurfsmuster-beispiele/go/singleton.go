package singleton

import (
	"sync"
)

// Singleton is a struct representing the singleton instance.
type Singleton struct {
	// Add fields or methods as needed
}

var instance *Singleton
var once sync.Once

// GetInstance returns the singleton instance, creating it if it doesn't exist.
func GetInstance() *Singleton {
	once.Do(func() {
		instance = &Singleton{}
		// Initialization code, if needed
	})
	return instance
}
