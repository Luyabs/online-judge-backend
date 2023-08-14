if redis.call('get',KEYS[1])
    then return 0;
else redis.call('set',KEYS[1],ARGV[1]);
    redis.call('expire',KEYS[1],ARGV[2]);
    return  1;
end;
