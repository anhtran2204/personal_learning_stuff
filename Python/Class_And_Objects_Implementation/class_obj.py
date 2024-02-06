def my_object(cls):
        def get_value(name):
            if name in attributes:
                return attributes[name]
            else:
                value = cls['get'](name)
                return bind_method(value, obj)
        def set_value(name, value):
            attributes[name] = value
        attributes = {}
        obj = {'get': get_value, 'set': set_value}
        return obj

def bind_method(value, obj):
        if callable(value):
            def method(*args):
                return value(obj, *args)
            return method
        else:
            return value

def my_class(attributes, base_class=None):
        def get_value(name):
            if name in attributes:
                return attributes[name]
            elif base_class is not None:
                return base_class['get'](name)
        def set_value(name, value):
            attributes[name] = value
        def new(*args):
            return init_object(obj, *args)
        obj = {'get': get_value, 'set': set_value, 'new': new}
        return obj

def init_object(obj, *args):
        new_obj = my_object(obj)
        init = obj['get']('__init__')
        if init:
            init(new_obj, *args)
        return new_obj

def make_account_class():
        """Return the Account class, which has deposit and withdraw methods."""
        interest = 0.02
        def __init__(self, account_holder):
            self['set']('holder', account_holder)
            self['set']('balance', 0)
        def deposit(self, amount):
            """Increase the account balance by amount and return the new balance."""
            new_balance = self['get']('balance') + amount
            self['set']('balance', new_balance)
            return self['get']('balance')
        def withdraw(self, amount):
            """Decrease the account balance by amount and return the new balance."""
            balance = self['get']('balance')
            if amount > balance:
                return 'Insufficient funds'
            self['set']('balance', balance - amount)
            return self['get']('balance')
        return my_class(locals())

Account = make_account_class()
kirk_account = Account['new']('Kirk')
print(kirk_account['get']('holder'))
print(kirk_account['get']('interest'))
print(kirk_account['get']('deposit')(20))
print(kirk_account['get']('withdraw')(5))