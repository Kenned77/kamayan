class ArrayList
  attr_reader :size

  def initialize
    @array = FixedArray.new(10)
    @size = 0
  end

  def [](index)
    check_bounds(index)
    @array[index]
  end

  # Define a method "<<" which takes a single argument. This method should
  # append the argument to the end of this ArrayList and increase the size by
  # 1. The return value must be self.
  def <<(arg)
    if (@size == @array.size)
      temp_array = @array
      @array = FixedArray.new(@size + 10)
      @size.times do |i|
        @array[i] = temp_array[i]
      end
    end

    @array[@size] = arg
    @size += 1
    self
  end

  # Define a method ">>" which takes a single argument. This method should
  # prepend the argument to the beginning of this ArrayList and increase the
  # size by 1. The return value must be self.

  def >>(arg)
    if (@size == @array.size)
      temp_array = @array
      @array = FixedArray.new(@size + 10)
      @size.times do |i|
        @array[i] = temp_array[i]
      end
    end

    temp_array = @array

    @array = FixedArray.new(temp_array.size)

    @size.times do |i|
      @array[i+1] = temp_array[i]
    end

    @array[0] = arg
    @size += 1
    self
  end





  # Define a method "[]=" which takes 2 arguments. This method should set the
  # value at the index defined in the first argument such that array_list[index]
  # will return the second argument.
  #
  # If the index is negative, an IndexError should be raised.
  #
  # If the index is bigger than the current size of the @array, the @array
  # should be replaced with a bigger FixedArray to fit the new index. All
  # indexes between the former last element and the new index should be
  # initialized with nil. An additional buffer should be included in the new
  # FixedArray (in case the array is grown more), though this is not required.
  #
  # The size after this method is called depends on the index provided. An
  # existing index would not affect the size, but an index greater than the last
  # index will add the difference to the size.

  def []=(index, value)
    check_bounds(index)
    @array[index] = value
    # array_list  = @array
    # array_list[index] = (value)
  end

  1. compare index to @array size
  2. if indix is bigger than @array
      a) store @array in a temp variable
      b) replace @array with new fixed array = index + 10
      c) write content from temp variable in to new @array
      d) set @size to index
  3. insert val in to @array at index
  4. increment size by 1
  5. return self

  # Define a "delete" method which takes a single index argument. This method
  # should delete the value at the provided index and return it. The size should
  # be 1 less than it was before this method was called. The index must be
  # within the bounds of the ArrayList, or an IndexError should be raised.





  def delete(index)
  #   check_bounds(index)
  #   result = @array[index]

  #   index_upto(size - 1) do |i|
  #     @array[i] = @array[i + 1]
  #   end

  #   @size -= 1
  #   result
  end





  private

  def check_bounds(index)
    check_lower_bound(index)
    check_upper_bound(index)
  end

  def check_lower_bound(index)
    raise IndexError, "Invalid index: #{index}" if index < 0
  end

  def check_upper_bound(index)
    raise IndexError, "Invalid index: #{index}" if index >= size
  end
end
