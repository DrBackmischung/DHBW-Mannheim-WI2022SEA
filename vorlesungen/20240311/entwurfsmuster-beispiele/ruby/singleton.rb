require 'singleton'

class MySingleton
  include Singleton

  attr_accessor :value

  def initialize
    @value = nil
  end
end

# Usage

# Attempt to create two instances
singleton_1 = MySingleton.instance
singleton_2 = MySingleton.instance

# Set a value in the first instance
singleton_1.value = "Hello, Singleton!"

# Access the value from the second instance
puts "Value from singleton_2: #{singleton_2.value}"

# Check if both variables point to the same instance
puts "singleton_1 and singleton_2 are the same instance: #{singleton_1.equal?(singleton_2)}"
