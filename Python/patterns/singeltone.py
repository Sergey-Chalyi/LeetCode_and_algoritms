class TestClass:
    __this_class = None
    __test_number = 0

    def __new__(cls):
        if cls.__this_class is None:
            cls.__this_class = super().__new__(cls)
        return cls.__this_class

test1 = TestClass()
test2 = TestClass()

print(test1 == test2)