INSERT INTO `order` (id,
                     name,
                     transaction_id,
                     blockchain_identifier,
                     execution_job_id,
                     order_details,
                     date_created,
                     last_updated)
VALUES (1700,
        'order1',
        'Aenean pulvinar...',
        'Aenean pulvinar...',
        1000,
        '''signedAppOrder: {
        app: ''''0x31115f9ed5fBb62a3a7aEd55831B643781D6f03b'''',
        appprice: ''''0'''',
        volume: ''''1'''',
        tag: ''''0x0000000000000000000000000000000000000000000000000000000000000000'''',
        datasetrestrict: ''''0x0000000000000000000000000000000000000000'''',
        workerpoolrestrict: ''''0x0000000000000000000000000000000000000000'''',
        requesterrestrict: ''''0xAC7fB30f96a2A38941f12927FCEFB1EdEaa387D3'''',
        salt: ''''0x2d73a7790610182e5703f3ab51dfccc3351c2a161504ff8b9b0e1cc4ee4c5cc3'''',
        sign: ''''0x0a8985f103b13bf7e7a6bc0d7334854405ebc7456e62214911c9e844c219b78e3ff180797d9d7f938e9d1a3b300e26dbcfb8159ba34b32f54a06e40f9f50648d1b''''
        }'',',
        '2021-09-03 04:30:00',
        '2021-09-03 04:30:00');
